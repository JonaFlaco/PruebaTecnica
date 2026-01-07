import { createRouter, createWebHistory } from "vue-router";
import ProductList from "@/views/ProductList.vue";
import ProductCreate from "@/views/ProductCreate.vue";

const routes = [
  { path: "/", redirect: "/products" },
  { path: "/products", component: ProductList },
  { path: "/products/new", component: ProductCreate },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
