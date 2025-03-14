/*
 * Copyright 2017-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.koin.compiler.generator

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Resolver
import org.koin.compiler.metadata.KoinMetaData

class DefaultModuleWriter(
    codeGenerator: CodeGenerator,
    resolver: Resolver,
    defaultModule: KoinMetaData.Module,
    generateDefaultModule: Boolean
) : ModuleWriter(codeGenerator, resolver, defaultModule) {

    override val fileName : String = "KoinDefault-${defaultModule.hashCode()}"
    override val hasExternalDefinitions: Boolean = true
    override val generateModuleBody: Boolean = generateDefaultModule

    override fun writeModuleFooter(closeBrackets : Boolean) {
        writeln(DEFAULT_MODULE_FOOTER)
    }
}