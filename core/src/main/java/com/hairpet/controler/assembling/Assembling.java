package com.hairpet.controler.assembling;

public interface Assembling<Entity, List> {

	public boolean assembling(List list);

	public boolean insertToDB(Entity bean);

}
