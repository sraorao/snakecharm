package com.jetbrains.snakecharm.lang.psi.impl.refs

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.jetbrains.python.psi.PyQualifiedExpression
import com.jetbrains.python.psi.impl.references.PyReferenceImpl
import com.jetbrains.python.psi.resolve.PyResolveContext
import com.jetbrains.snakecharm.lang.psi.SmkRuleLike
import com.jetbrains.snakecharm.lang.psi.SmkRuleOrCheckpointArgsSection
import com.jetbrains.snakecharm.lang.psi.SmkSection
import com.jetbrains.snakecharm.lang.psi.SmkSubworkflow

/**
 * This is fake reference which allow as to remove some results from resolve/completion
 *
 * 1. Remove [SmkRuleLike] elements which were added just as all [PsiNameIdentifierOwner] and
 *   [com.intellij.psi.PsiNamedElement]
 *      See [com.jetbrains.python.psi.resolve.PyResolveUtil.scopeCrawlUp] and `visitElement` in
 *      [com.jetbrains.python.codeInsight.dataflow.scope.impl.ScopeImpl.collectDeclarations]
 */
class SmkPyReferenceImpl(
        element: PyQualifiedExpression,
        context: PyResolveContext,
        private val inRunSection: Boolean
    ): PyReferenceImpl(element, context) {

    override fun resolveInner() = super.resolveInner().filter {
        !shouldBeRemovedFromDefaultScopeCrawlUpResults(it?.element, inRunSection)
    }

    override fun getVariants(): Array<Any> {
        val defaultVariants = super.getVariants()

        // remove rule like elements from basic completion (they are in the list because
        // python collects all named elements although we don't need this
        return defaultVariants.filter { v ->
            when (v) {
                is LookupElement -> !shouldBeRemovedFromDefaultScopeCrawlUpResults(v.psiElement, inRunSection)
                is PsiElement -> !shouldBeRemovedFromDefaultScopeCrawlUpResults(v, inRunSection)
                else -> true
            }
        }.toTypedArray()
    }

    companion object {
        fun shouldBeRemovedFromDefaultScopeCrawlUpResults(
                element: PsiElement?, inRunSection: Boolean
        ): Boolean {
            // TODO: re-implement using smk visitor
            var shouldBeRemoved = (element is SmkSection) && (element !is SmkSubworkflow)
            if (shouldBeRemoved && inRunSection) {
                shouldBeRemoved = element !is SmkRuleOrCheckpointArgsSection
            }
            return shouldBeRemoved
        }
    }
}