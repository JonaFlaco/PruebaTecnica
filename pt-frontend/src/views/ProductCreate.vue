<template>
  <div class="product-create-container">
    <div class="form-header">
      <h1 class="page-title">➕ Nuevo Producto</h1>
      <p class="subtitle">Completa el formulario para agregar un nuevo producto</p>
    </div>

    <form @submit.prevent="saveProduct" class="product-form">
      <!-- Nombre -->
      <div class="form-group">
        <label for="name" class="form-label">
          <span class="label-icon">📝</span>
          Nombre del Producto
        </label>
        <input
          id="name"
          v-model="product.name"
          type="text"
          class="form-input"
          placeholder="Ej: Laptop Dell XPS 15"
          required
        />
      </div>

      <!-- Precio -->
      <div class="form-group">
        <label for="price" class="form-label">
          <span class="label-icon">💰</span>
          Precio
        </label>
        <div class="input-wrapper">
          <span class="input-prefix">$</span>
          <input
            id="price"
            v-model.number="product.price"
            type="number"
            step="0.01"
            min="0"
            class="form-input"
            placeholder="0.00"
            required
          />
        </div>
      </div>

      <!-- Stock -->
      <div class="form-group">
        <label for="stock" class="form-label">
          <span class="label-icon">📦</span>
          Stock
        </label>
        <input
          id="stock"
          v-model.number="product.stock"
          type="number"
          min="0"
          class="form-input"
          placeholder="0"
          required
        />
      </div>

      <!-- Botones -->
      <div class="form-actions">
        <button type="submit" class="btn-submit">
          <span>💾</span>
          Guardar Producto
        </button>
        <router-link to="/products" class="btn-cancel">
          <span>❌</span>
          Cancelar
        </router-link>
      </div>
    </form>
  </div>
</template>

<script lang="ts">
import { defineComponent, ref } from "vue";
import { useRouter } from "vue-router";
import ProductService from "@/services/ProductService";
import { ProductCreate } from "@/interface/ProductInterface/ProductCreate";

export default defineComponent({
  name: "ProductCreate",
  setup() {
    const router = useRouter();
    const isLoading = ref(false);

    const product: ProductCreate = {
      name: "",
      price: 0,
      stock: 0,
    };

    const saveProduct = async () => {
      try {
        isLoading.value = true;
        await ProductService.createProduct(product);
        router.push("/products");
      } catch (error) {
        console.error("Error al guardar producto:", error);
        alert("Error al guardar el producto. Por favor, intenta nuevamente.");
      } finally {
        isLoading.value = false;
      }
    };

    return {
      product,
      saveProduct,
      isLoading,
    };
  },
});
</script>

<style scoped>
.product-create-container {
  background: white;
  border-radius: 16px;
  padding: 2.5rem;
  box-shadow: 0 10px 40px rgba(0, 0, 0, 0.1);
  max-width: 600px;
  margin: 0 auto;
}

.form-header {
  text-align: center;
  margin-bottom: 2.5rem;
}

.page-title {
  color: #2d3748;
  font-size: 2rem;
  font-weight: 700;
  margin-bottom: 0.5rem;
}

.subtitle {
  color: #718096;
  font-size: 1rem;
}

.product-form {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.form-group {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.form-label {
  color: #2d3748;
  font-weight: 600;
  font-size: 0.95rem;
  display: flex;
  align-items: center;
  gap: 0.5rem;
}

.label-icon {
  font-size: 1.2rem;
}

.form-input {
  padding: 0.875rem 1rem;
  border: 2px solid #e2e8f0;
  border-radius: 10px;
  font-size: 1rem;
  transition: all 0.3s ease;
  font-family: inherit;
  color: #2d3748;
  background: #f7fafc;
}

.form-input:focus {
  outline: none;
  border-color: #667eea;
  background: white;
  box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
}

.form-input::placeholder {
  color: #a0aec0;
}

.input-wrapper {
  position: relative;
  display: flex;
  align-items: center;
}

.input-prefix {
  position: absolute;
  left: 1rem;
  color: #718096;
  font-weight: 600;
  font-size: 1.1rem;
}

.input-wrapper .form-input {
  padding-left: 2.5rem;
}

.form-actions {
  display: flex;
  gap: 1rem;
  margin-top: 1rem;
}

.btn-submit {
  flex: 1;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  color: white;
  padding: 1rem 1.5rem;
  border: none;
  border-radius: 10px;
  font-weight: 600;
  font-size: 1rem;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
  transition: all 0.3s ease;
  box-shadow: 0 4px 15px rgba(102, 126, 234, 0.3);
}

.btn-submit:hover {
  transform: translateY(-2px);
  box-shadow: 0 6px 20px rgba(102, 126, 234, 0.4);
}

.btn-submit:active {
  transform: translateY(0);
}

.btn-submit:disabled {
  opacity: 0.6;
  cursor: not-allowed;
  transform: none;
}

.btn-cancel {
  flex: 1;
  background: white;
  color: #718096;
  padding: 1rem 1.5rem;
  border: 2px solid #e2e8f0;
  border-radius: 10px;
  font-weight: 600;
  font-size: 1rem;
  text-decoration: none;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 0.5rem;
  transition: all 0.3s ease;
}

.btn-cancel:hover {
  background: #f7fafc;
  border-color: #cbd5e0;
  color: #4a5568;
  transform: translateY(-2px);
}

@media (max-width: 768px) {
  .product-create-container {
    padding: 1.5rem;
  }

  .page-title {
    font-size: 1.5rem;
  }

  .form-actions {
    flex-direction: column;
  }

  .btn-submit,
  .btn-cancel {
    width: 100%;
  }
}
</style>
