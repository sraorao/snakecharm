package com.jetbrains.snakecharm.stringLanguage.lang.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiPolyVariantReference
import com.intellij.psi.util.PsiTreeUtil
import com.jetbrains.python.psi.impl.PyReferenceExpressionImpl
import com.jetbrains.python.psi.resolve.PyResolveContext
import com.jetbrains.python.psi.types.PyType
import com.jetbrains.python.psi.types.TypeEvalContext
import com.jetbrains.snakecharm.lang.psi.SmkSLReferenceExpression
import com.jetbrains.snakecharm.lang.psi.types.SmkAvailableForSubscriptionType
import com.jetbrains.snakecharm.stringLanguage.lang.parser.SmkSLTokenTypes
import com.jetbrains.snakecharm.stringLanguage.lang.psi.references.SmkSLSubscriptionKeyReference

class SmkSLKeyExpression(node: ASTNode) : PyReferenceExpressionImpl(node), SmkSLReferenceExpression {
    override fun getName() = referencedName

    override fun getNameElement() = node.findChildByType(SmkSLTokenTypes.ACCESS_KEY)

    override fun getType(context: TypeEvalContext, key: TypeEvalContext.Key): PyType? = null

    override fun getReference(): PsiPolyVariantReference {
        val type = qualifier?.let { PyResolveContext.defaultContext().typeEvalContext.getType(it) }
        val subscriptionType: PyType? = when (type) {
            is SmkAvailableForSubscriptionType -> type
            else -> null
        }
        return SmkSLSubscriptionKeyReference(this, subscriptionType)
    }


    override fun getReference(context: PyResolveContext) = getReference()

    override fun getQualifier() =
            PsiTreeUtil.getParentOfType(this, SmkSLSubscriptionExpression::class.java)
                    ?.children
                    ?.firstOrNull { it is SmkSLReferenceExpression }
                    as? SmkSLReferenceExpression

    override fun toString(): String {
        return "SmkSLKeyExpression: [${this.referencedName}]"
    }

}