package ar.edu.iua.iw3.backend.util.controllers;

public final class Constants {
	public static final String URL_API = "/api";
	public static final String URL_API_VERSION = "/v1";
	public static final String URL_BASE = URL_API + URL_API_VERSION;

	public static final String URL_PRODUCTS = URL_BASE + "/products";

	public static final String URL_INTEGRATION = URL_BASE + "/integration";
	public static final String URL_INTEGRATION_CLI1 = URL_INTEGRATION + "/cli1";
	public static final String URL_INTEGRATION_CLI2 = URL_INTEGRATION + "/cli2";

	/*
	 * [GET] /api/v1/products 
	 * [GET] /api/v1/products/{id} 
	 * [POST] /api/v1/products
	 * [PUT] /api/v1/products 
	 * [DELETE] /api/v1/products/{id}
	 */
}
