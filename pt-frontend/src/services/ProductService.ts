import { ProductCreate } from "@/interface/ProductInterface/ProductCreate";
import { Product } from "@/interface/ProductInterface/ProductInterface";
import axios, { type AxiosResponse } from "axios";

const API_PRODUCT_BASE_URL = "http://localhost:8080/api/products";

class ProductService {
  getProducts(): Promise<AxiosResponse<Product[]>> {
    return axios.get<Product[]>(API_PRODUCT_BASE_URL);
  }

  createProduct(product: ProductCreate): Promise<AxiosResponse<Product>> {
    return axios.post<Product>(API_PRODUCT_BASE_URL, product);
  }
}

export default new ProductService();
