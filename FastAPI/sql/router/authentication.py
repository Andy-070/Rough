from fastapi import APIRouter , Depends , HTTPException,status
import schema ,database,models,hash,tokenn
from sqlalchemy.orm import Session
from fastapi.security import OAuth2PasswordRequestForm

router = APIRouter(
    tags=['authentication']
)

get_db = database.get_db


@router.post('/login')
def login(request:OAuth2PasswordRequestForm = Depends(),db:Session = Depends(get_db)):
    user = db.query(models.User).filter(models.User.email == request.username).first()
    if not user:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND,detail="invalid")
    
    if not hash.Hash.verify(user.password,request.password):
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND,detail="invalid")
    
    
    access_token = tokenn.create_access_token(data={"sub": user.email})
    return {"access_token":access_token, "token_type":"bearer"}
