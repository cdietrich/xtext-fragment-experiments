/*
 * generated by Xtext 2.25.0
 */
package org.xtext.example.mydsl;

import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.resource.XtextResource;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class MyDslRuntimeModule extends AbstractMyDslRuntimeModule {
	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return MyDslXtextResource.class;
	}
	
	@Override
	public Class<? extends ILinker> bindILinker() {
		return MyDslLazyLinker.class;
	}
	
	public Class<? extends IFragmentProvider> bindIFragmentProvider() {
		return MyDslFragmentProvider.class;
	}
}