
import org.parboiled.BaseParser;
import static org.parboiled.BaseParser.EOI;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author obsa
 */
@BuildParseTree
public class CustomerForm extends BaseParser<Object> {
   
    
 public Rule InputLine(){
 
     return Sequence(Full_Name(), Address(), Number(), EOI);
 }   
 
 
//--------------------------------Name code----------------------------     
 Rule Full_Name() {
        return Sequence (Word(), Space(),Word(),Space(),Optional(Word()), Space());
    }
 

Rule Word(){
    return OneOrMore(Sequence(UpperLetter(),LowerLetter(),ZeroOrMore('.')));
 
} 

/*
 Rule First(){
     return OneOrMore(Sequence(UpperLetter(),LowerLetter()));
 }
 
 
 Rule Last(){
     return OneOrMore(Sequence(UpperLetter(),LowerLetter()));
 }
 
 Rule Middle(){
     return Optional(Sequence(UpperLetter(),LowerLetter()));
 }
*/
 
//-------------------------------------------------------------------
 
//---------------------Address----------------------------------------------

 Rule Address(){
     return Sequence(StreetNumber(), Space() , StreetName(),City(),State(),  Country() );
   }
   
    Rule StreetNumber(){
        return OneOrMore(CharRange('0', '9'));
    }

    Rule StreetName(){
        return Sequence(OneOrMore(SubName()), Comma());
    }
    
    Rule SubName(){
        return Sequence(ZeroOrMore(CharRange('A','Z')),OneOrMore(CharRange('a','z')), ZeroOrMore('.'), Space());

    }
 
    
    Rule City(){
        return Sequence(OneOrMore(PartsOfCity()), Comma());
    }

     Rule PartsOfCity(){
        
        return Sequence(ZeroOrMore(CharRange('A','Z')), OneOrMore(CharRange('a','z')),ZeroOrMore('.'), Space());
    
    }
    
    Rule State(){
        return Sequence(OneOrMore(CharRange('A', 'Z')),Optional(ZeroOrMore(CharRange('a', 'z')), Comma()));
    }

    Rule Country(){
        return Sequence(PartsOfCountry(),Optional(OneOrMore(PartsOfCountry2())) );
    }
    
    Rule PartsOfCountry(){
        
        return Sequence(OneOrMore(CharRange('A','Z')), ZeroOrMore(CharRange('a','z')),ZeroOrMore('.'), Space());
    
    } 
     Rule PartsOfCountry2(){
        
        return Sequence(ZeroOrMore(CharRange('A','Z')), OneOrMore(CharRange('a','z')),ZeroOrMore('.'), Space());
    
    } 



//-----------------------------------------------------------------------------

//-----------------------------------Phone Number ------------------------------
    
Rule Number(){
    
    return Sequence(Area(),Space(),Middle(), Hyphen() ,End());

}    

Rule Area(){
    
    return Sequence( ParenthesisBegining(),CharRange('0', '9'), CharRange('0', '9') , CharRange('0', '9') ,   ParenthesisEnding());

}


Rule Middle(){
  return Sequence( CharRange('0', '9'),CharRange('0', '9') , CharRange('0', '9'));
}

Rule End(){

  return Sequence( CharRange('0', '9'),CharRange('0', '9') , CharRange('0', '9') ,  CharRange('0', '9'));

}

 
    

//-----------------------------------------------------------------------------
 
 // --------------------------------Fundumental code----------------------------------
 
Rule Hyphen(){
    return OneOrMore('-');
}

Rule ParenthesisBegining(){
    return OneOrMore('(');
}

Rule ParenthesisEnding(){
    return OneOrMore(')');
}

 Rule Comma(){
     return ZeroOrMore(",");
 }

 Rule Space(){
     return ZeroOrMore(" ");
 }
 
 Rule LowerLetter(){
   return ZeroOrMore(CharRange('a','z'));
 }
 
  Rule UpperLetter(){
   return OneOrMore(CharRange('A','Z'));
 }
 
//----------------------------------------------------------------------------
}
