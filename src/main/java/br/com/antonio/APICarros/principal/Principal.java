package br.com.antonio.APICarros.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.antonio.APICarros.model.Dados;
import br.com.antonio.APICarros.model.Modelos;
import br.com.antonio.APICarros.model.Veiculo;
import br.com.antonio.APICarros.services.ConsumoAPI;
import br.com.antonio.APICarros.services.ConverteDados;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu(){
        // System.out.println(json);
        System.out.println("**** OPÇÕES ****\r\n" + //
                        "\r\n" + //
                        "Carros\r\n" + //
                        "\r\n" + //
                        "Motos\r\n" + //
                        "\r\n" + //
                        "Caminhões\r\n" + //
                        "\r\n" + //
                        "Digite uma das opções para consultar valores:");
        var opcaoAutomovel = leitura.nextLine();
        String endereco;

        if (opcaoAutomovel.toLowerCase().contains("carros")) {
            endereco = ENDERECO + "carros/marcas";
        } else if (opcaoAutomovel.toLowerCase().contains("motos")) {
            endereco = ENDERECO + "motos/marcas";
        } else {
            endereco = ENDERECO + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        var marcas = conversor.obterLista(json, Dados.class);

        marcas.stream()
            .sorted(Comparator.comparing(Dados::codigo))
            .forEach(System.out::println);

        System.out.println("\nQual Marca você Deseja consultar?(Utilize os códigos)");
        var codigoMarca = leitura.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(endereco);
        Modelos modeloLista = conversor.obterDados(json, Modelos.class);
        
        System.out.println("\nModelos dessa marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do veículo para consulta: \n");
        var nomeVeiculo = leitura.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("\nDigite o código do modelo para consultar valores:\n");
        var codigoVeiculo = leitura.nextLine();

        endereco = endereco + "/" + codigoVeiculo + "/anos";
        json = consumo.obterDados(endereco);

        List<Dados> anos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");
        veiculos.forEach(System.out::println);
    }
}
