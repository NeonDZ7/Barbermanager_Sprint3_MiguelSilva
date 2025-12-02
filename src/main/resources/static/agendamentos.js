const urlBase = "http://localhost:8080/agendamentos";

async function listarAgendamentos() {
    try {
        const res = await fetch(urlBase);
        const data = await res.json();

        const tbody = document.getElementById("agendamentosTable");
        tbody.innerHTML = "";

        data.forEach(ag => {
            const tr = document.createElement("tr");

            tr.innerHTML = `
                <td>${ag.id}</td>
                <td>${ag.nomeCliente}</td>
                <td>${ag.servico}</td>
                <td>${ag.dataHora}</td>
                <td>R$ ${ag.preco.toFixed(2)}</td>
                <td>${ag.barbeiroId}</td>

                <!-- STATUS EM PORTUGUÊS -->
                <td>${ag.status === "SCHEDULED" ? "Agendado" : "Cancelado"}</td>

                <td>
                    <button class="btn-edit" onclick="editarAgendamento(${ag.id})">Editar</button>
                    <button class="btn-delete" onclick="deletarAgendamento(${ag.id})">Excluir</button>

                    <!-- BOTÃO AJUSTADO -->
                    <button class="btn-status" onclick="toggleStatus(${ag.id})">
                        ${ag.status === "SCHEDULED" ? "Cancelar" : "Ativar"}
                    </button>
                </td>
            `;

            tbody.appendChild(tr);
        });

    } catch (error) {
        console.error("Erro ao listar agendamentos:", error);
    }
}

document.getElementById("agendamentoForm").addEventListener("submit", async e => {
    e.preventDefault();

    const agendamento = {
        nomeCliente: document.getElementById("nomeCliente").value,
        servico: document.getElementById("servico").value,
        dataHora: document.getElementById("dataHora").value,
        preco: parseFloat(document.getElementById("preco").value),
        barbeiroId: parseInt(document.getElementById("barbeiroId").value),
        status: "SCHEDULED"
    };

    try {
        const res = await fetch(urlBase, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(agendamento)
        });

        if (res.ok) {
            listarAgendamentos();
            document.getElementById("agendamentoForm").reset();
        }

    } catch (error) {
        console.error("Erro ao adicionar agendamento:", error);
    }
});

async function deletarAgendamento(id) {
    try {
        await fetch(`${urlBase}/${id}`, { method: "DELETE" });
        listarAgendamentos();
    } catch (error) {
        console.error("Erro ao deletar agendamento:", error);
    }
}

async function editarAgendamento(id) {
    try {
        const res = await fetch(`${urlBase}/${id}`);
        const ag = await res.json();

        document.getElementById("agendamentoId").value = ag.id;
        document.getElementById("nomeCliente").value = ag.nomeCliente;
        document.getElementById("servico").value = ag.servico;
        document.getElementById("dataHora").value = ag.dataHora;
        document.getElementById("preco").value = ag.preco;
        document.getElementById("barbeiroId").value = ag.barbeiroId;

        document.getElementById("btnSubmit").style.display = "none";
        document.getElementById("btnSalvarEdicao").style.display = "inline-block";

    } catch (error) {
        console.error("Erro ao carregar agendamento:", error);
    }
}
document.getElementById("btnSalvarEdicao").addEventListener("click", async () => {
    const id = document.getElementById("agendamentoId").value;

    const agendamento = {
        nomeCliente: document.getElementById("nomeCliente").value,
        servico: document.getElementById("servico").value,
        dataHora: document.getElementById("dataHora").value,
        preco: parseFloat(document.getElementById("preco").value),
        barbeiroId: parseInt(document.getElementById("barbeiroId").value)
    };

    try {
        await fetch(`${urlBase}/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(agendamento)
        });

        document.getElementById("agendamentoForm").reset();
        document.getElementById("btnSubmit").style.display = "inline-block";
        document.getElementById("btnSalvarEdicao").style.display = "none";

        listarAgendamentos();

    } catch (error) {
        console.error("Erro ao salvar edição:", error);
    }
});

async function toggleStatus(id) {
    try {
        await fetch(`${urlBase}/${id}/toggleStatus`, { method: "PUT" });
        listarAgendamentos();
    } catch (error) {
        console.error("Erro ao alternar status:", error);
    }
}

listarAgendamentos();