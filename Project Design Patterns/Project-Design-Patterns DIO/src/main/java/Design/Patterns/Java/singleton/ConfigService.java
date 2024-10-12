package Design.Patterns.Java.singleton;

import org.springframework.stereotype.Component;

@Component
public class ConfigService {
    private static ConfigService instance;
    private String config = "default";

    // Construtor privado para garantir que ninguém crie uma instância manualmente
    private ConfigService() {}

    // Método público que retorna a única instância da classe
    public static synchronized ConfigService getInstance() {
        if (instance == null) {
            instance = new ConfigService();
        }
        return instance;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
