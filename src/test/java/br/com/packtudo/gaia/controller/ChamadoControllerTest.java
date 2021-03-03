package br.com.packtudo.gaia.controller;

import br.com.packtudo.gaia.model.dto.ChamadoDTO;
import br.com.packtudo.gaia.service.ChamadoService;
import br.com.packtudo.gaia.utils.UtilsTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ChamadoControllerTest extends UtilsTest {

    @Autowired
    private MockMvc mockMvc;

    //@MockBean
  //  private ChamadoService chamadoService;

    @LocalServerPort
    private int port;

    @Autowired
    private ObjectMapper objectMapper;

    public ChamadoControllerTest() {
    }

    @BeforeEach
    public void initialize() {
       // when(chamadoService.findAll()).thenReturn(asList(obterChamado(123), obterChamado(456)));
    }

    @Test
    public void findAll() throws Exception {
  /*      mockMvc.perform(post("/v1/chamados").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(obterChamadoDTO(null))))
                .andExpect(status().isOk());
*/

        MvcResult result = mockMvc.perform(get("/v1/chamados"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        List<ChamadoDTO> chamados = asList(objectMapper.readValue(result.getResponse().getContentAsString(), ChamadoDTO[].class));
        for (ChamadoDTO c : chamados) {
            assertNotNull(c.getIdChamado());
            assertNotNull(c.getDescChamado());
            assertNotNull(c.getDescTituloChamado());
            assertNotNull(c.getStatusChamado());
            assertNotNull(c.getStatusChamado().getCodStatusChamado());
            assertNotNull(c.getStatusChamado().getDescStatusChamado());
            assertNotNull(c.getDataHoraInclusao());
        }
    }

}