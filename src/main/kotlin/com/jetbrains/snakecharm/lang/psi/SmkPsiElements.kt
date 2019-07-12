package com.jetbrains.snakecharm.lang.psi

import com.intellij.psi.PsiNamedElement
import com.intellij.psi.StubBasedPsiElement
import com.jetbrains.python.codeInsight.controlflow.ScopeOwner
import com.jetbrains.python.psi.PyDocStringOwner
import com.jetbrains.python.psi.PyElement
import com.jetbrains.python.psi.PyStatement
import com.jetbrains.python.psi.PyStatementListContainer
import com.jetbrains.snakecharm.lang.SnakemakeNames
import com.jetbrains.snakecharm.lang.psi.stubs.SmkCheckpointStub
import com.jetbrains.snakecharm.lang.psi.stubs.SmkRuleStub
import com.jetbrains.snakecharm.lang.psi.stubs.SmkSubworkflowStub

interface SmkRule: SmkRuleOrCheckpoint, StubBasedPsiElement<SmkRuleStub>

interface SmkCheckPoint: SmkRuleOrCheckpoint, StubBasedPsiElement<SmkCheckpointStub>

interface SmkSubworkflow: SmkRuleLike<SmkSubworkflowArgsSection>, StubBasedPsiElement<SmkSubworkflowStub>

interface SmkRuleOrCheckpointArgsSection : SmkArgsSection { // PyNamedElementContainer
    companion object {
        val EXECUTION_KEYWORDS = setOf(
                SnakemakeNames.SECTION_SHELL, SnakemakeNames.SECTION_SCRIPT,
                SnakemakeNames.SECTION_WRAPPER, SnakemakeNames.SECTION_CWL
        )

        val PARAMS_NAMES = setOf(
                SnakemakeNames.SECTION_OUTPUT, SnakemakeNames.SECTION_INPUT, SnakemakeNames.SECTION_PARAMS, SnakemakeNames.SECTION_LOG, SnakemakeNames.SECTION_RESOURCES,
                SnakemakeNames.SECTION_BENCHMARK, SnakemakeNames.SECTION_VERSION, SnakemakeNames.SECTION_MESSAGE, SnakemakeNames.SECTION_SHELL, SnakemakeNames.SECTION_THREADS, SnakemakeNames.SECTION_SINGULARITY,
                SnakemakeNames.SECTION_PRIORITY, SnakemakeNames.SECTION_WILDCARD_CONSTRAINTS, SnakemakeNames.SECTION_GROUP, SnakemakeNames.SECTION_SHADOW,
                SnakemakeNames.SECTION_CONDA,
                SnakemakeNames.SECTION_SCRIPT, SnakemakeNames.SECTION_WRAPPER, SnakemakeNames.SECTION_CWL
        )
    }
}


interface SmkSubworkflowArgsSection: SmkArgsSection {
    companion object {
        val PARAMS_NAMES = setOf(
                "workdir", "snakefile", "configfile"
        )
    }
}

interface SmkWorkflowArgsSection: SmkArgsSection // PyNamedElementContainer

interface SmkRunSection: SmkSection, PyStatementListContainer, PyDocStringOwner
    //ScopeOwner, // for control flow

interface SmkWorkflowPythonBlockSection : SmkSection,
        ScopeOwner, // for control flow
        PyStatementListContainer, PyDocStringOwner

interface SmkWorkflowLocalrulesSection: PyStatement, SmkArgsSection
        // SmkArgsSection

interface SmkWorkflowRuleorderSection: PyStatement, SmkArgsSection

interface SmkReferenceExpression: PyElement, PsiNamedElement