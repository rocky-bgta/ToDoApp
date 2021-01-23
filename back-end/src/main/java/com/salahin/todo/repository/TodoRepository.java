/**
 * Created By: Md. Nazmus Salahin
 * Created Date: 23-Jan-2021
 * Time: 4:19 AM
 * Modified By:
 * Modified date:
 * (C) CopyRight Salahin ltd.
 */

package com.salahin.todo.repository;

import com.salahin.todo.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, UUID> {
	
	 Optional<TodoEntity> findById(UUID id);
	
	@Query("select e from TodoEntity e")
	List<TodoEntity> findAllToDo();
	
	@Modifying
	@Query("UPDATE TodoEntity e SET e.name = :name, e.description = :description, e.date = :date where e.id = :id")
	void updateTodoById(@Param("name") String name,
	                    @Param("description") String description,
	                    @Param("date") Date date,
	                    @Param("id") UUID id);
	
	@Query("DELETE FROM TodoEntity e where e.id = ?1")
	void deleteTodoById(UUID uuid);
	
}