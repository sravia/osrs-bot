








package api.wrappers;

import api.methods.Calculations;
import api.methods.Client;
import api.methods.Menu;
import api.methods.Nodes;
import environment.Data;
import reflection.ClassHook;
import reflection.FieldHook;

import java.awt.*;

public class EntityNode {
	public Object currentObject;
	public static ClassHook currentHook;
	private static FieldHook next;
	private static FieldHook previous;
	public EntityNode(Object o){
		currentObject = o;
		if(currentHook==null){
			currentHook = Data.runtimeClassHooks.get("EntityNode");
			next = currentHook.getFieldHook("getNext");
			previous = currentHook.getFieldHook("getPrevious");
		}
	}
	public static void resetHooks(){
		currentHook=null;
		next=null;
		previous=null;
	}
	public EntityNode getNext(){
		if(next==null)
			next = currentHook.getFieldHook("getNext");
		if(next!=null){
			Object data = next.get(currentObject);
			if(data!=null)
				return new EntityNode(data);
		}
		return null;
	}
	public EntityNode getPrevious(){
		if(previous==null)
			previous = currentHook.getFieldHook("getPrevious");
		if(previous!=null){
			Object data = previous.get(currentObject);
			if(data!=null)
				return new EntityNode(data);
		}
		return null;
	}
}
