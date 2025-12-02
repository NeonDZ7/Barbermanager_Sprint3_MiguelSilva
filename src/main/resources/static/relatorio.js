document.getElementById("btnBuscar").addEventListener("click", buscarPorData);

function buscarPorData() {
    const dataSelecionada = document.getElementById("filtroData").value;

    if (!dataSelecionada) {
        alert("Selecione uma data!");
        return;
    }

    fetch("http://localhost:8080/agendamentos")
        .then(res => res.json())
        .then(agendamentos => {
            const tabela = document.getElementById("tabelaRelatorio");
            tabela.innerHTML = "";

            const filtrados = agendamentos.filter(a => a.dataHora.startsWith(dataSelecionada));

            if (filtrados.length === 0) {
                tabela.innerHTML = `
                    <tr><td colspan="7" style="text-align:center; color:#ccc;">
                        Nenhum agendamento encontrado nessa data.
                    </td></tr>
                `;
                return;
            }

            filtrados.forEach(a => {
                const dataFormatada = new Date(a.dataHora).toLocaleString("pt-BR");
                const statusPt = a.status === "CANCELED" ? "Cancelado" : "Agendado";

                tabela.innerHTML += `
                    <tr>
                        <td>${a.id}</td>
                        <td>${a.nomeCliente}</td>
                        <td>${a.servico}</td>
                        <td>${dataFormatada}</td>
                        <td>R$ ${a.preco.toFixed(2)}</td>
                        <td>${a.barbeiroId}</td>
                        <td>${statusPt}</td>
                    </tr>
                `;
            });
        });
}
