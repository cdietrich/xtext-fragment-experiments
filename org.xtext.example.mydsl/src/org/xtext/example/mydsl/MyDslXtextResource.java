package org.xtext.example.mydsl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;

public class MyDslXtextResource extends LazyLinkingResource {
	
	private List<EObject> objects;
	public List<EObject> getObjects() {
		return objects;
	}

	private Map<Object, Integer> fragmentToObject;
	
	public Map<Object, Integer> getObjToFragment() {
		return fragmentToObject;
	}

	@Override
	protected void clearInternalState() {
		objects = null;
		fragmentToObject = null;
		super.clearInternalState();
	}
	
	public void registerEObject(EObject o) {
		// maybe filter for stuff we know can be sources and targets
		synchronized (this) {
			if (objects == null) {
				objects = new ArrayList<>();
				fragmentToObject = new HashMap<>();
			}
			objects.add(o);
			fragmentToObject.put(o, objects.size()-1);
		}
	}

}
