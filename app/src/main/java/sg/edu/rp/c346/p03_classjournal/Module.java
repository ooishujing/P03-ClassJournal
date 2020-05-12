package sg.edu.rp.c346.p03_classjournal;

import java.io.Serializable;

public class Module implements  Serializable {
    private String code;
    private String description;
    private String email;

    public Module(String code, String description, String email) {
        this.code = code;
        this.description = description;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }
}
