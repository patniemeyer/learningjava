package magicbeans;

import javax.swing.*;
import java.beans.beancontext.*;
import java.util.*;

public class ShowContext extends JTabbedPane implements BeanContextProxy {
	BeanContext context;
	BeanContextServices services;
	JList servicesList = new JList(), beansList = new JList();

	public ShowContext() {
		addTab( "Beans", new JScrollPane( beansList ) );
		addTab( "Services", new JScrollPane( servicesList ) );
	}

    private BeanContextChildSupport beanContextChild = 
		new BeanContextChildSupport() {

		public void initializeBeanContextResources()	{
			context= getBeanContext();
			try	{
				services = (BeanContextServices)context;
			} catch (ClassCastException	ex) { /* No BeanContextServices */ } 

			updateBeanList();
			updateServicesList();

			context.addBeanContextMembershipListener( 
				new BeanContextMembershipListener() {
					public void childrenAdded( BeanContextMembershipEvent e ) { 
						updateBeanList();
					}
					public void childrenRemoved( BeanContextMembershipEvent e ){
						updateBeanList();
					}
				} );
			services.addBeanContextServicesListener( 
				new BeanContextServicesListener() {
					public void serviceAvailable( 
								BeanContextServiceAvailableEvent e ) {
						updateServicesList();
					}
					public void serviceRevoked( 
								BeanContextServiceRevokedEvent e ) {
						updateServicesList();
					}
				} );
		}
    };

	void updateServicesList() {
		if ( services == null )
			return;
		Iterator it = services.getCurrentServiceClasses();
		Vector<Object> v = new Vector<Object>();
		while( it.hasNext() )
			v.addElement( it.next() );
		servicesList.setListData( v );
	}
	void updateBeanList() {
		Iterator it = context.iterator();
		Vector<Object> v = new Vector<Object>();
		while( it.hasNext() )
			v.addElement( it.next() );
		beansList.setListData( v );
	}

    public BeanContextChild getBeanContextProxy() {
		return beanContextChild;
    }
}
