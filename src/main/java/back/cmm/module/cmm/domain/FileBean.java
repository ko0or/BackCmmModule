package back.cmm.module.cmm.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`file`")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@SequenceGenerator(
//        name="FILE_SEQ_GEN", //시퀀스 제너레이터 이름
//        sequenceName="FILE_SEQ", //시퀀스 이름
//        initialValue=1, //시작값
//        allocationSize=1 //메모리를 통해 할당할 범위 사이즈
//)
public class FileBean extends RegOnlyBean {

    @Id
    @GeneratedValue
//    @GeneratedValue(
//            strategy=GenerationType.SEQUENCE, //사용할 전략을 시퀀스로 선택
//            generator="FILE_SEQ" //식별자 생성기를 설정해놓은 USER_SEQ_GEN으로 설정
//    )
    private Long uid;

    @Column(name = "logical_nm")
    private String logicalNm;
    @Column(name = "physical_nm")
    private String physicalNm;
    @Column(name = "path")
    private String path;

}
