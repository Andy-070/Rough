from fastapi import Depends,status,Response,HTTPException ,APIRouter
import schema,models,hash
from database import get_db
from sqlalchemy.orm import Session

router = APIRouter(
    prefix='/user',
    tags=["user"]
)


@router.post('/',response_model=schema.ShowUser)
def create_user(request:schema.user,db:Session = Depends(get_db)):
    new_user = models.User(name = request.name, email = request.email, password = hash.Hash.bcrypt(request.password))
    db.add(new_user)
    db.commit()
    db.refresh(new_user)
    return new_user


@router.get('/{id}',response_model=schema.ShowUser)
def get_user(id,db:Session = Depends(get_db)):
    user = db.query(models.User).filter(models.User.id == id).first()
    return user