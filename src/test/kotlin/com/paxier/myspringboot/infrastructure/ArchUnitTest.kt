package com.paxier.myspringboot.infrastructure

import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.library.Architectures
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.RestController

@AnalyzeClasses(packages = ["com.paxier.myspringboot"], importOptions = [ImportOption.DoNotIncludeTests::class])
class ArchUnitTest {
    @ArchTest
    val hexagonalArchitecture = Architectures.onionArchitecture()
        .domainModels("..domain..")
        .applicationServices("..application..")
        .adapter("adapter", "..adapter..")
        .withOptionalLayers(true)

    @ArchTest
    val restControllers = ArchRuleDefinition.classes()
        .that().areAnnotatedWith(RestController::class.java)
        .should().resideInAPackage("..adapter.rest..")

    @ArchTest
    val inPorts = ArchRuleDefinition.classes()
        .that().resideInAPackage("..application.port.in..")
        .should().beInterfaces()

    @ArchTest
    val outPorts = ArchRuleDefinition.classes()
        .that().resideInAPackage("..application.port.out..")
        .should().beInterfaces()

    @ArchTest
    val repositories = ArchRuleDefinition.classes()
        .that().areAssignableTo(Repository::class.java)
        .should().resideInAPackage("..application.port.out..")

}