package com.jetbrains.snakecharm.lang.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult
import com.intellij.psi.util.PsiTreeUtil
import com.jetbrains.python.psi.impl.PyElementImpl
import com.jetbrains.python.psi.resolve.RatedResolveResult
import com.jetbrains.python.psi.types.PyType
import com.jetbrains.python.psi.types.TypeEvalContext
import com.jetbrains.snakecharm.codeInsight.resolve.SmkResolveUtil
import com.jetbrains.snakecharm.lang.psi.SmkCheckPoint
import com.jetbrains.snakecharm.lang.psi.SmkFile
import com.jetbrains.snakecharm.lang.psi.SmkReferenceExpression
import com.jetbrains.snakecharm.lang.psi.SmkRule
import com.jetbrains.snakecharm.lang.psi.stubs.SmkCheckpointNameIndex
import com.jetbrains.snakecharm.lang.psi.stubs.SmkRuleNameIndex
import com.jetbrains.snakecharm.lang.psi.types.AbstractSmkRuleOrCheckpointsListType


class SmkReferenceExpressionImpl(node: ASTNode): PyElementImpl(node), SmkReferenceExpression {
    override fun getName() = getReferenceName()

    override fun getType(context: TypeEvalContext, key: TypeEvalContext.Key): PyType? = null

    override fun getReference(): PsiReference? = SmkRuleOrCheckpointNameReference(this, TextRange(0, textLength))

    class SmkRuleOrCheckpointNameReference(
            element: SmkReferenceExpression,
            textRange: TextRange
    ) : PsiReferenceBase.Poly<SmkReferenceExpression>(element, textRange, true) {
        private val key: String = element.text

        override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
            val rules = AbstractSmkRuleOrCheckpointsListType
                    .findAvailableRuleLikeElementByName(element, key, SmkRuleNameIndex.KEY, SmkRule::class.java)
                    { getRules().map{ (_, psi) -> psi }}
            val checkpoints = AbstractSmkRuleOrCheckpointsListType
                    .findAvailableRuleLikeElementByName(element, key, SmkCheckpointNameIndex.KEY, SmkCheckPoint::class.java)
                    { getCheckpoints().map{ (_, psi) -> psi }}

            return (rules + checkpoints)
                    .map { RatedResolveResult(SmkResolveUtil.RATE_NORMAL, it) }
                    .toTypedArray()
        }

        override fun handleElementRename(newElementName: String) =
                        SmkResolveUtil.renameNameNode(newElementName, element.getNameElement(), element)

        private fun getRules() = PsiTreeUtil.getParentOfType(element, SmkFile::class.java)
                ?.collectRules() ?: emptyList()

        private fun getCheckpoints() = PsiTreeUtil.getParentOfType(element, SmkFile::class.java)
                ?.collectCheckPoints()
                ?: emptyList()
    }
}

