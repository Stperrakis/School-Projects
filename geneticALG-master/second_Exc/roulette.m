function [ child1,child2,ppl,found ] = roulette( ppl )
found =1;
Sum_Of_Val = 0;
for i = 1: size(ppl,1)
    if ppl(:,size(ppl,2))~=-1
        Sum_Of_Val =Sum_Of_Val+ ppl(i,size(ppl,2));
    end
end

counter = [1 1];
for child = 1:2
    random_num = randi([0 Sum_Of_Val]);
    we_have_A_WINNER = 0;
    i = counter(child);
    
    while we_have_A_WINNER ==0
        if(i>size(ppl,1))
            counter = [1 1];
            found = 0;
            break;
        end
        if ppl(i,size(ppl,2))>(-1)
            random_num = random_num + ppl(i,size(ppl,2));
        end
        if random_num >= Sum_Of_Val
            ppl(i,size(ppl,2)) = -1;
            we_have_A_WINNER = 1;
            counter(child) = i;
        end
        i = i+1;
    end
end
child1 =counter(1);
child2 =counter(2);
end

