from fastapi import Depends,status,Response,HTTPException ,APIRouter
import schema,models, oauthh2
from database import get_db
from sqlalchemy.orm import Session
from repo import blog

router = APIRouter(
   prefix='/blog',
   tags=["blog"]
)

@router.get('/')
def all(db:Session = Depends(get_db)):
   return blog.all(db)



@router.get('/{id}',status_code=200,response_model=schema.show)
def get(id,response :Response, db:Session = Depends(get_db),current_user:schema.user = Depends(oauthh2.get_current_user)):
    blog = db.query(models.Blog).filter(models.Blog.id == id).first()
    if not blog :

        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND,detail=f"not found for {id}")
    
        # response.status_code = status.HTTP_404_NOT_FOUND
        # return {'details':f"not found for {id}"}
    
    return blog


@router.post('/',status_code=status.HTTP_201_CREATED)
def create(request:schema.Blog,db:Session=Depends(get_db)):
    new_blog = models.Blog(title = request.title, body = request.body,user_id= 1)
    db.add(new_blog)
    db.commit()
    db.refresh(new_blog)
    return new_blog


@router.put('/{id}',status_code=status.HTTP_202_ACCEPTED)
def update(id,request:schema.Blog,db:Session = Depends(get_db)):
    # db.query(models.Blog).filter(models.Blog.id == id).update({'title':'updated title'})
   blog = db.query(models.Blog).filter(models.Blog.id == id)
   if not blog.first():
    raise HTTPException(status_code=status.HTTP_404_NOT_FOUND,detail=f"not foung{id}")
   
   blog.update(request.dict())
   db.commit()
   return 'up'




@router.delete('/blog/{id}',status_code=status.HTTP_204_NO_CONTENT)
def destroy(id,db:Session = Depends(get_db)):
    blog = db.query(models.Blog).filter(models.Blog.id == id).delete(synchronize_session=False)
    db.commit()
    return 'done'
