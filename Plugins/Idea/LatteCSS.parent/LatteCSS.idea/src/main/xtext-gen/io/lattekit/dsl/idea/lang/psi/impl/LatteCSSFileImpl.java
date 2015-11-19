/*
 * generated by Xtext 2.9.0.beta5
 */
package io.lattekit.dsl.idea.lang.psi.impl;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import io.lattekit.dsl.idea.lang.LatteCSSFileType;
import io.lattekit.dsl.idea.lang.LatteCSSLanguage;
import org.eclipse.xtext.psi.impl.BaseXtextFile;

public final class LatteCSSFileImpl extends BaseXtextFile {

	public LatteCSSFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, LatteCSSLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return LatteCSSFileType.INSTANCE;
	}
}