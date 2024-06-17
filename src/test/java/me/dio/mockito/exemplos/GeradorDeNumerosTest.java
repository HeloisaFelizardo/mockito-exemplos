package me.dio.mockito.exemplos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

/**
 * Teste da classe {@Link GeradorDeNumeros} exemplificando testes de métodos estáticos
 */
@ExtendWith(MockitoExtension.class)
public class GeradorDeNumerosTest {

    @Test
    void validaGeracaoListaDeNumeros() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        try (MockedStatic<GeradorDeNumeros> gerador = Mockito.mockStatic(GeradorDeNumeros.class)) {
            gerador.when(() -> GeradorDeNumeros.geraNumerosAleatorios(anyInt()))
                    .thenReturn(integers);

            Assertions.assertEquals(integers, GeradorDeNumeros.geraNumerosAleatorios(8));
        }
    }

    @Test
    void validaGeracaoListaDeNumerosSemInformarTamanho() {
        List<Integer> integers = List.of(10, 9, 8, 6);

        try (MockedStatic<GeradorDeNumeros> gerador = Mockito.mockStatic(GeradorDeNumeros.class)) {
            gerador.when(GeradorDeNumeros::geraNumerosAleatorios).thenReturn(integers);

            Assertions.assertEquals(integers, GeradorDeNumeros.geraNumerosAleatorios());
        }
    }
}
