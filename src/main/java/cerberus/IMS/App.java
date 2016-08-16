package cerberus.IMS;

import org.hibernate.Criteria;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import cerberus.IMS.beans.Address;
import cerberus.IMS.beans.StateAbbrv;

public class App 
{
    public static void main( String[] args )
    {
    	Session session = SessionFactoryManager.getInstance().openSession();
    	Criteria criteria = session.createCriteria(StateAbbrv.class);
    	
    	criteria.add(Restrictions.eq("stateName", "Colorado"));
    	
    	StateAbbrv myState = (StateAbbrv) criteria.uniqueResult();
    	
    	Address address3 = new Address("14791 Rocky Mountain Road", "Suite #2172", "Denver", "80123", myState);
    	
    	DataLayer layer = new DataLayer();
    	
    	// --> Add New // layer.createRecord(address3);
    	
    }
}
