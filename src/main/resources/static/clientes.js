const urlBase = "http://localhost:8080/clientes";

async function listarClientes() {
    const res = await fetch(urlBase);
    const data = await res.json();

    const tbody = document.getElementById("clientesTable");
    tbody.innerHTML = "";

    data.forEach(c => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${c.id}</td>
            <td>${c.nome}</td>
            <td>${c.telefone}</td>
            <td>
                <button class="btn btn-edit" onclick="editarCliente(${c.id})">Editar</button>
                <button class="btn btn-delete" onclick="deletarCliente(${c.id})">Excluir</button>
            </td>
        `;
        tbody.appendChild(tr);
    });
}

document.getElementById("clienteForm").addEventListener("submit", async e => {
    e.preventDefault();

    const id = document.getElementById("clienteId").value.trim();
    const nome = document.getElementById("nome").value.trim();
    const telefone = document.getElementById("telefone").value.trim();

    if (!nome || !telefone) return;

    if (id) {
        await fetch(`${urlBase}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ nome, telefone })
        });

        document.getElementById("clienteId").value = "";
        document.getElementById("btnSubmit").style.display = "inline-block";
        document.getElementById("btnSalvarEdicao").style.display = "none";
    } else {
        await fetch(urlBase, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ nome, telefone })
        });
    }

    document.getElementById("clienteForm").reset();
    listarClientes();
});

async function deletarCliente(id) {
    await fetch(`${urlBase}/${id}`, { method: "DELETE" });
    listarClientes();
}

async function editarCliente(id) {
    const res = await fetch(`${urlBase}/${id}`);
    const c = await res.json();

    document.getElementById("clienteId").value = c.id;
    document.getElementById("nome").value = c.nome;
    document.getElementById("telefone").value = c.telefone;

    document.getElementById("btnSubmit").style.display = "none";
    document.getElementById("btnSalvarEdicao").style.display = "inline-block";
}

document.getElementById("btnSalvarEdicao").addEventListener("click", () => {
    document.getElementById("clienteForm").requestSubmit(); 
});

listarClientes();
