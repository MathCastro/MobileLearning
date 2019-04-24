//
//  UserBO.swift
//  exercicios
//
//  Created by mcastro on 24/04/2019.
//  Copyright © 2019 mcastro. All rights reserved.
//

import Foundation

class UserBO {
    var id: Int
    var email: String?
    var password: Int
    
    init(id: Int, email: String?, password: Int){
        self.id = id
        self.email = email
        self.password = password
    }
}
