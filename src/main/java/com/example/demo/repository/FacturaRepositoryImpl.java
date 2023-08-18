package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Factura;

//tarea realizada antes pero ya esta subido a github y es por eso este comentario
@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Factura seleccionarPorCodigo(String codigo) {
		TypedQuery<Factura> myQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f WHERE f.codigo = :datoCodigo", Factura.class);
		myQuery.setParameter("datoCodigo", codigo);
		return myQuery.getSingleResult();
	}

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public Factura guardarYDevolver(Factura factura) {
		// TODO Auto-generated method stub
		this.insertar(factura);
		return this.buscarID(factura.getId());
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public void actualizarParcial(String codigoActual, String codigoNuevo) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createQuery("UPDATE Factura f SET f.codigo= :datoCodigo WHERE f.codigo= :datoCondicion");
		myQuery.setParameter("datoCodigo", codigoNuevo);
		myQuery.setParameter("datoCondicion", codigoActual);
		myQuery.executeUpdate();
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		Factura f = this.buscarID(id);
		this.entityManager.remove(f);
	}

	@Override
	public List<Factura> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f", Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public Factura buscarID(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura.class, id);
	}

}
