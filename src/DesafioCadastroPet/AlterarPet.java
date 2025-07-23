package DesafioCadastroPet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class AlterarPet {
    List<String> buscaPet = new ArrayList<String>();
    Scanner scanner = new Scanner(System.in);
    File listaAnimais = new File("AnimaisCadastrados");



    public void mostrarMenuCriterio() {
        buscaPet.add("1 - Nome ou sobrenome");
        buscaPet.add("2 - Sexo");
        buscaPet.add("3 - Idade");
        buscaPet.add("4 - Peso");
        buscaPet.add("5 - Raça");
        buscaPet.add("6 - Endereço");
        for (String linha : buscaPet) {
            System.out.println(linha);
        }
    }

    public Integer validaCriterio() {
        while (true) {
            try {
                System.out.println("Selecione o número do critério que você deseja realizar a sua busca:  ");
                Integer resposta = Integer.parseInt(scanner.nextLine());
                return resposta;
            } catch (NumberFormatException e) {
                System.err.println("Favor, responda novamente informando apenas o número:  ");
            }
        }
    }

    public void realizarBusca(Integer criterio)  {
        Path file = Paths.get("petsCadastrados");
        try (Stream<Path> files = Files.list(file)) {
            files.forEach(arquivo -> lerArquivo(arquivo,criterio));
        } catch (IOException e) {
            System.err.println("Erro ao listar arquivos: " + e.getMessage());
        }
        }
    public void lerArquivo(Path arquivo, Integer criterio) {
        try (BufferedReader reader = Files.newBufferedReader(arquivo, StandardCharsets.UTF_8)) {
            String line;
            List<String> dadosAnimais = new ArrayList<>();
            while ((line = reader.readLine())!= null)
                dadosAnimais.add(line.substring(2));
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo " + arquivo.getFileName() + ": " + e.getMessage());
        }
    }



}

