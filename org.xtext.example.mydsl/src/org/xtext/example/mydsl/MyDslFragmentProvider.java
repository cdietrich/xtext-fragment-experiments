package org.xtext.example.mydsl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.DefaultFragmentProvider;

public class MyDslFragmentProvider extends DefaultFragmentProvider {
	
	
	@Override
	public EObject getEObject(Resource resource, String fragment, Fallback fallback) {
		if (resource instanceof MyDslXtextResource) {
			if (fragment.charAt(0) == '§') {
				EObject result = ((MyDslXtextResource) resource).getObjects().get(Integer.valueOf(fragment.substring(1)));
				if (result != null) {
					return result;
				}
			}
		}
		return super.getEObject(resource, fragment, fallback);
	}
	
	@Override
	public String getFragment(EObject obj, Fallback fallback) {
		Resource resource = obj.eResource();
		if (resource instanceof MyDslXtextResource) {
			Integer integer = ((MyDslXtextResource) resource).getObjToFragment().get(obj);
			if (integer != null) {				
				String string = "§"+integer;
				return string;
			}
		}
		return super.getFragment(obj, fallback);
	}

}
