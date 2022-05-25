package com.example.aula04.model;

import javax.persistence.GenerationType;

public @interface IdGneratedValue {

    GenerationType strategy();

}
