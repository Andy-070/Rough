const getCount = () => {
    let count =0;
    return ()=> ++count;
};

const counter1 = getCount();
const counter2 = getCount();


console.log(counter1())
console.log(counter1())
console.log(counter2())
console.log(counter2())