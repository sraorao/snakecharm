package com.jetbrains.snakecharm.codeInsight.resolve

import com.intellij.openapi.module.ModuleUtilCore
import com.intellij.psi.util.PsiTreeUtil
import com.jetbrains.python.psi.PyQualifiedExpression
import com.jetbrains.python.psi.resolve.PyReferenceResolveProvider
import com.jetbrains.python.psi.resolve.RatedResolveResult
import com.jetbrains.python.psi.types.TypeEvalContext
import com.jetbrains.snakecharm.codeInsight.ImplicitPySymbolsProvider
import com.jetbrains.snakecharm.codeInsight.SmkCodeInsightScope
import com.jetbrains.snakecharm.lang.SnakemakeLanguageDialect
import com.jetbrains.snakecharm.lang.SnakemakeNames
import com.jetbrains.snakecharm.lang.psi.SmkRuleOrCheckpoint
import com.jetbrains.snakecharm.lang.psi.SmkRuleOrCheckpointArgsSection

class SMKImplicitPySymbolsResolveProvider : PyReferenceResolveProvider {
    override fun resolveName(
            element: PyQualifiedExpression,
            context: TypeEvalContext
    ): List<RatedResolveResult> {
        if (SnakemakeLanguageDialect.isInsideSmkFile(context.origin)) {
            val module = ModuleUtilCore.findModuleForPsiElement(element)
            if (module != null) {
                val contextScope = SmkCodeInsightScope[element]
                val cache = ImplicitPySymbolsProvider.instance(module).cache

                val items = SmkCodeInsightScope.values().asSequence()
                        .filter { symbolScope -> contextScope.includes(symbolScope) }
                        .flatMap { symbolScope -> cache.filter(symbolScope, element.name!!).asSequence() }
                        .map {
                            RatedResolveResult(SmkResolveUtil.IMPLICIT_SYMBOLS_PRIORITY, it.psiDeclaration)
                        }.toMutableList()

                if (contextScope == SmkCodeInsightScope.RULELIKE_RUN_SECTION) {
                    if (element.referencedName == SnakemakeNames.SECTION_THREADS) {
                        val ruleOrCheckpoint = PsiTreeUtil.getParentOfType(
                                element, SmkRuleOrCheckpoint::class.java
                        )!!

                        val threadsSection = ruleOrCheckpoint.statementList.statements.asSequence()
                                .filterIsInstance<SmkRuleOrCheckpointArgsSection>()
                                .filter { it.name == SnakemakeNames.SECTION_THREADS }.firstOrNull()

                         items.add(RatedResolveResult(SmkResolveUtil.IMPLICIT_SYMBOLS_PRIORITY, threadsSection ?: ruleOrCheckpoint))
                    }
                }
                return items
            }
        }
        return emptyList()
    }
}
