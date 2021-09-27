package by.khmara.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "url")
public class Redirect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alias;
    private String url;

    public Redirect(String alias, String url) {
        this.alias = alias;
        this.url = url;
    }
}
