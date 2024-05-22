package IntervjuPiO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WebConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCorsFilterConfiguration() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/files")
                        .header("Origin", "https://intervjupio.netlify.app"))
                .andExpect(status().isOk())
                .andExpect(header().string("Access-Control-Allow-Origin", "https://intervjupio.netlify.app"))
                .andExpect(header().string("Access-Control-Expose-Headers", "Content-Disposition"));
    }
}
