package org.xtext.example.mydsl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.IDiagnosticProducer;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.Multimap;

public class MyDslLazyLinker extends LazyLinker {
	
	@Override
	protected void installProxies(EObject obj, IDiagnosticProducer producer, Multimap<Setting, INode> settingsToLink) {
		Resource r = obj.eResource();
		if (r instanceof MyDslXtextResource) {
			((MyDslXtextResource) r).registerEObject(obj);
		}
		super.installProxies(obj, producer, settingsToLink);
	}

}
