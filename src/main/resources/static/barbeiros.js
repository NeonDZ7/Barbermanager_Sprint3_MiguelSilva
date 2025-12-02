const urlBase = "http://localhost:8080/barbeiros";

async function listarBarbeiros() {
    const res = await fetch(urlBase);
    const data = await res.json();
    const tbody = document.getElementById("barbeirosTable");

    tbody.innerHTML = "";

    data.forEach(b => {
        const tr = document.createElement("tr");
        tr.innerHTML = `
            <td>${b.id}</td>
            <td>${b.nome}</td>
            <td>${b.telefone}</td>
            <td>
                <button class="btn btn-edit" onclick="editarBarbeiro(${b.id})">Editar</button>
                <button class="btn btn-delete" onclick="deletarBarbeiro(${b.id})">Excluir</button>
            </td>
        `;
        tbody.appendChild(tr);
    });
}

document.getElementById("barbeiroForm").addEventListener("submit", async e => {
    e.preventDefault();

    const nome = document.getElementById("nome").value;
    const telefone = document.getElementById("telefone").value;

    const res = await fetch(urlBase, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ nome, telefone })
    });

    if(res.ok) listarBarbeiros();
    document.getElementById("barbeiroForm").reset();
});

async function deletarBarbeiro(id) {
    await fetch(`${urlBase}/${id}`, { method: "DELETE" });
    listarBarbeiros();
}

async function editarBarbeiro(id) {
    const res = await fetch(`${urlBase}/${id}`);
    const b = await res.json();

    document.getElementById("barbeiroId").value = b.id;
    document.getElementById("nome").value = b.nome;
    document.getElementById("telefone").value = b.telefone;

    document.getElementById("btnSubmit").style.display = "none";
    document.getElementById("btnSalvarEdicao").style.display = "inline-block";
}

document.getElementById("btnSalvarEdicao").addEventListener("click", async () => {
    const id = document.getElementById("barbeiroId").value;
    const nome = document.getElementById("nome").value;
    const telefone = document.getElementById("telefone").value;

    await fetch(`${urlBase}/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ nome, telefone })
    });

    document.getElementById("barbeiroForm").reset();

    document.getElementById("btnSubmit").style.display = "inline-block";
    document.getElementById("btnSalvarEdicao").style.display = "none";

    listarBarbeiros();
});

listarBarbeiros();
