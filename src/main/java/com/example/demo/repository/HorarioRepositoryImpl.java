package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Horario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HorarioRepositoryImpl implements IHorarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Horario seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Horario> myQuery = this.entityManager
				.createQuery("SELECT h FROM Horario h WHERE h.codigoClase = :datoCodigoClase", Horario.class);
		myQuery.setParameter("datoCodigoClase", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(horario);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(horario);
	}

	@Override
	public void actualizarParcial(String nombreActual, String nombreNuevo) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createQuery("UPDATE Horario h SET h.nombre= :datoNombre WHERE h.nombre= :datoCondicion");
		myQuery.setParameter("datoNombre", nombreNuevo);
		myQuery.setParameter("datoCondicion", nombreActual);
		myQuery.executeUpdate();
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		Horario h = this.buscarID(id);
		this.entityManager.remove(h);
	}

	@Override
	public List<Horario> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Horario> myQuery = this.entityManager.createQuery("SELECT h FROM Horario h", Horario.class);
		return myQuery.getResultList();
	}

	@Override
	public Horario buscarID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Horario.class, id);
	}

}
