package com.hairpet.controler.db;

import java.util.List;

public interface DAO<Entity, Index> {

	public boolean insert(Entity bean) throws Exception;

	public Index update(Entity bean) throws Exception;

	public boolean delete(Index id) throws Exception;

	public Entity find(Index id) throws Exception;

	public List<Entity> searchAll(Entity bean) throws Exception;

	public Index exists(Entity bean) throws Exception;

}
