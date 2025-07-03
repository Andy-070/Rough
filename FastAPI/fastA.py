from fastapi import FastAPI
from typing import Optional
from pydantic import BaseModel
import uvicorn
# uvicorn fastA:main --reload   to run the server

app = FastAPI()

@app.get('/')

def index():
    return {"data":{"name":"andy"}}

@app.get('/about')
def about():
    return {"data":"about"}

@app.get('/feed/back')
def back():
    return {"feedback":{'1','2'}}
    
@app.get('/feed/{id}')
def show(id:int):
    return {"data":id}



# http://127.0.0.1:8000/qwerty/7/asdf?limit=123&pub=True      otherwise set the values in the fun
@app.get('/qwerty/{id}/asdf')
def lambd(id,limit,pub:bool):
    if pub : return f"{limit} for pub"
    else : return pub
    # return id

    
class Blog(BaseModel):
    title:str
    body:str
    pub:Optional[bool]

@app.post('/blog')
def createBlog(request:Blog):
    return {"data":f"blog if creareed as title {request.title}"}








# if __name__ == "__fastA__":
#     uvicorn.run(app,host="127.0.0.1",port=9000)
# you can also run the file by python3...

