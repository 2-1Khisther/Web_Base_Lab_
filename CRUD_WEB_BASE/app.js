const API_BASE = "http://localhost:8080/users/testuser/todos"; // change username if needed

document.addEventListener("DOMContentLoaded", loadTodos);
document.getElementById("addBtn").addEventListener("click", addTodo);

let editingId = null; // track which todo is being edited

function loadTodos() {
  fetch(API_BASE)
    .then((res) => res.json())
    .then((data) => {
      const tbody = document.querySelector("#todoTable tbody");
      tbody.innerHTML = "";
      data.forEach((todo) => {
        const row = document.createElement("tr");
        row.innerHTML = `
          <td>${todo.id}</td>
          <td>${todo.description}</td>
          <td>${todo.targetDate || ""}</td>
          <td>${todo.done ? "✅" : "❌"}</td>
          <td>
            <button onclick="editTodo(${todo.id}, '${todo.description.replace(/'/g, "\\'")}')">Edit</button>
            <button onclick="deleteTodo(${todo.id})">Delete</button>
          </td>
        `;
        tbody.appendChild(row);
      });
    })
    .catch((err) => console.error("Error loading todos:", err));
}

function addTodo() {
  const desc = document.getElementById("description").value.trim();
  if (!desc) return alert("Please enter a todo description!");

  const todo = {
    username: "testuser",
    description: desc,
    done: false,
    targetDate: new Date().toISOString().slice(0, 10),
  };

  fetch(API_BASE, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(todo),
  })
    .then(() => {
      document.getElementById("description").value = "";
      loadTodos();
    })
    .catch((err) => console.error("Error adding todo:", err));
}

function deleteTodo(id) {
  fetch(`${API_BASE}/${id}`, { method: "DELETE" })
    .then(() => loadTodos())
    .catch((err) => console.error("Error deleting todo:", err));
}

function editTodo(id, description) {
  document.getElementById("description").value = description;
  document.getElementById("addBtn").style.display = "none";
  document.getElementById("updateBtn").style.display = "inline-block";

  editingId = id;

  document.getElementById("updateBtn").onclick = () => updateTodo();
}

function updateTodo() {
  const newDesc = document.getElementById("description").value.trim();
  if (!newDesc) return alert("Description cannot be empty!");

  const todo = {
    id: editingId,
    username: "testuser",
    description: newDesc,
    done: false,
    targetDate: new Date().toISOString().slice(0, 10),
  };

  fetch(`${API_BASE}/${editingId}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(todo),
  })
    .then(() => {
      document.getElementById("description").value = "";
      document.getElementById("addBtn").style.display = "inline-block";
      document.getElementById("updateBtn").style.display = "none";
      editingId = null;
      loadTodos();
    })
    .catch((err) => console.error("Error updating todo:", err));
}
