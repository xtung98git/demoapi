package com.tungx.demoapi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tblimagef")
public class ImageF implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

}
