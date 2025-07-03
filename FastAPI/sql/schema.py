from pydantic import BaseModel
from typing import List

class Blog(BaseModel):
    title:str 
    body:str

class BlogBase(Blog):
    class config():
        orm = True

class user(BaseModel):
    name:str
    email:str
    password:str



class ShowUser(BaseModel):
    class config():
        orm = True

    name:str
    email:str
    blogs:List[Blog] = [

    ]


class show(BaseModel):
    class config():
        orm = True
    title:str
    body:str
    creator:ShowUser


class Login(BaseModel):
    username : str
    password : str


class Token(BaseModel):
    access_token: str
    token_type: str


class TokenData(BaseModel):
    email: str | None = None