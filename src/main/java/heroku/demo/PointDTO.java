package heroku.demo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PointDTO implements Serializable {

    private double x;
    private double y;
    private String id;
    private String name;
    private String comments;
    private String locationHref;
    private String colorsName;
    private String colorsComments;
    private String dyskHref;

}
