<template>
  <div class="product-list-container">
    <div class="header-section">
      <h1 class="page-title">📦 Lista de Productos</h1>
      <router-link to="/products/new" class="btn-primary">
        <span>➕</span> Nuevo Producto
      </router-link>
    </div>

    <div class="table-container" v-if="products.length > 0">
      <table class="products-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Stock</th>
            <th>Fecha de Creación</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="product in products" :key="product.id" class="table-row">
            <td class="id-cell">{{ product.id }}</td>
            <td class="name-cell">{{ product.name }}</td>
            <td class="price-cell">${{ formatPrice(product.price) }}</td>
            <td>
              <span :class="['stock-badge', getStockClass(product.stock)]">
                {{ product.stock }}
              </span>
            </td>
            <td class="date-cell">{{ formatDate(product.createdAt) }}</td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="empty-state" v-else>
      <div class="empty-icon">📭</div>
      <h2>No hay productos registrados</h2>
      <p>Crea tu primer producto para comenzar</p>
      <router-link to="/products/new" class="btn-primary">
        <span>➕</span> Crear Producto
      </router-link>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import ProductService from "@/services/ProductService";
import { Product } from "@/interface/ProductInterface/ProductInterface";

export default defineComponent({
  name: "ProductList",
  data() {
    return {
      products: [] as Product[],
    };
  },
  created() {
    ProductService.getProducts().then((res) => {
      this.products = res.data;
    });
  },
  methods: {
    formatPrice(price: number): string {
      return price.toFixed(2);
    },
    formatDate(dateString: string): string {
      if (!dateString) return '-';
      const date = new Date(dateString);
      return date.toLocaleDateString('es-ES', {
        year: 'numeric',
        month: 'short',
        day: 'numeric',
        hour: '2-digit',
        minute: '2-digit'
      });
    },
    getStockClass(stock: number): string {
      if (stock === 0) return 'stock-zero';
      if (stock < 10) return 'stock-low';
      if (stock < 50) return 'stock-medium';
      return 'stock-high';
    }
  }
});
</script>

<style scoped>
.product-list-container {
  background: white;
  border-radius: 16px;
  padding: 2rem;
  box-shadow: 0 10px 40px rgba(0, 0, 0, 0.1);
  min-height: 500px;
}

.header-section {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2rem;
  flex-wrap: wrap;
  gap: 1rem;
}

.page-title {
  color: #2d3748;
  font-size: 2rem;
  font-weight: 700;
  margin: 0;
}

.btn-primary {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  padding: 0.75rem 1.5rem;
  border-radius: 10px;
  text-decoration: none;
  font-weight: 600;
  display: inline-flex;
  align-items: center;
  gap: 0.5rem;
  transition: all 0.3s ease;
  box-shadow: 0 4px 15px rgba(102, 126, 234, 0.3);
  border: none;
  cursor: pointer;
}

.btn-primary:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 20px rgba(102, 126, 234, 0.4);
}

.table-container {
  overflow-x: auto;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
}

.products-table {
  width: 100%;
  border-collapse: collapse;
  background: white;
}

.products-table thead {
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
}

.products-table th {
  padding: 1rem;
  text-align: left;
  font-weight: 600;
  font-size: 0.9rem;
  text-transform: uppercase;
  letter-spacing: 0.5px;
}

.products-table tbody tr {
  border-bottom: 1px solid #e2e8f0;
  transition: all 0.2s ease;
}

.products-table tbody tr:hover {
  background: #f7fafc;
  transform: scale(1.01);
}

.products-table td {
  padding: 1rem;
  color: #4a5568;
}

.id-cell {
  font-weight: 600;
  color: #667eea;
}

.name-cell {
  font-weight: 500;
  color: #2d3748;
}

.price-cell {
  font-weight: 700;
  color: #48bb78;
  font-size: 1.1rem;
}

.stock-badge {
  display: inline-block;
  padding: 0.4rem 0.8rem;
  border-radius: 20px;
  font-weight: 600;
  font-size: 0.85rem;
}

.stock-zero {
  background: #fed7d7;
  color: #c53030;
}

.stock-low {
  background: #feebc8;
  color: #c05621;
}

.stock-medium {
  background: #bee3f8;
  color: #2b6cb0;
}

.stock-high {
  background: #c6f6d5;
  color: #22543d;
}

.date-cell {
  color: #718096;
  font-size: 0.9rem;
}

.empty-state {
  text-align: center;
  padding: 4rem 2rem;
}

.empty-icon {
  font-size: 5rem;
  margin-bottom: 1rem;
}

.empty-state h2 {
  color: #2d3748;
  margin-bottom: 0.5rem;
  font-size: 1.5rem;
}

.empty-state p {
  color: #718096;
  margin-bottom: 2rem;
  font-size: 1.1rem;
}

@media (max-width: 768px) {
  .product-list-container {
    padding: 1rem;
  }

  .header-section {
    flex-direction: column;
    align-items: stretch;
  }

  .page-title {
    font-size: 1.5rem;
  }

  .products-table {
    font-size: 0.85rem;
  }

  .products-table th,
  .products-table td {
    padding: 0.75rem 0.5rem;
  }
}
</style>
