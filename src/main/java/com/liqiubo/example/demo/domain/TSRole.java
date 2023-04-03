package com.liqiubo.example.demo.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "t_s_role")
public class TSRole implements Serializable {
  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid")
  private String id;
  private String rolecode;
  private String rolename;
  private String updateName;
  private java.sql.Timestamp updateDate;
  private String updateBy;
  private String createName;
  private java.sql.Timestamp createDate;
  private String createBy;

}
