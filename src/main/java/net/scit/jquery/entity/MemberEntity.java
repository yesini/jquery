package net.scit.jquery.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name="member")  //실제 DB 테이블 이름으로 설정
public class MemberEntity {

  @Id
  @Column(name="userid")
  private String userid;

  @Column(name="userpwd")
  private String userpwd;

  @Column(name="age")
  private int age;

  @Column(name="location")
  private String location;
}
