/**
 */
package CVLMetamodelMaster.Main;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configurable Unit Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p><span style="font-size:8pt;">A configurable unit usage is a variation point which facilitates per-usage configuration of a configurable unit. Each usage variation point references the CU of which it is a usage, and also references a base model link-end touching the base model container referenced by the CU referenced by the usage. </span></p><p><span style="font-size:8pt;">A usage variation point must be bound to a CSVpec, the resolution of which configures the particular usage. The type of that CVSpec must be the same as the type of the CVSpec to which the configurable unit it uses is bound. During materialization the base model container referenced by the CU (referenced by the usage) is deeply cloned, and the base model link-end identified by the usage is redirected to the clone.</span></p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link CVLMetamodelMaster.Main.ConfigurableUnitUsage#getUsedUnit <em>Used Unit</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.ConfigurableUnitUsage#getUsageReference <em>Usage Reference</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.ConfigurableUnitUsage#getLinkEndIdentifier <em>Link End Identifier</em>}</li>
 *   <li>{@link CVLMetamodelMaster.Main.ConfigurableUnitUsage#getUnitUsageInterface <em>Unit Usage Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see CVLMetamodelMaster.Main.MainPackage#getConfigurableUnitUsage()
 * @model
 * @generated
 */
public interface ConfigurableUnitUsage extends CompositeVariationPoint {
	/**
	 * Returns the value of the '<em><b>Used Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The used unit.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Used Unit</em>' reference.
	 * @see #setUsedUnit(ConfigurableUnit)
	 * @see CVLMetamodelMaster.Main.MainPackage#getConfigurableUnitUsage_UsedUnit()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ConfigurableUnit getUsedUnit();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ConfigurableUnitUsage#getUsedUnit <em>Used Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Used Unit</em>' reference.
	 * @see #getUsedUnit()
	 * @generated
	 */
	void setUsedUnit(ConfigurableUnit value);

	/**
	 * Returns the value of the '<em><b>Usage Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Reference to the usage.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Usage Reference</em>' containment reference.
	 * @see #setUsageReference(LinkHandle)
	 * @see CVLMetamodelMaster.Main.MainPackage#getConfigurableUnitUsage_UsageReference()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	LinkHandle getUsageReference();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ConfigurableUnitUsage#getUsageReference <em>Usage Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Reference</em>' containment reference.
	 * @see #getUsageReference()
	 * @generated
	 */
	void setUsageReference(LinkHandle value);

	/**
	 * Returns the value of the '<em><b>Link End Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The identifier of the link end.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Link End Identifier</em>' attribute.
	 * @see #setLinkEndIdentifier(String)
	 * @see CVLMetamodelMaster.Main.MainPackage#getConfigurableUnitUsage_LinkEndIdentifier()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getLinkEndIdentifier();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ConfigurableUnitUsage#getLinkEndIdentifier <em>Link End Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Link End Identifier</em>' attribute.
	 * @see #getLinkEndIdentifier()
	 * @generated
	 */
	void setLinkEndIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Unit Usage Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>The interface of the unit usage. Derived as the extension of the binding CVSpec.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit Usage Interface</em>' reference.
	 * @see #setUnitUsageInterface(VInterface)
	 * @see CVLMetamodelMaster.Main.MainPackage#getConfigurableUnitUsage_UnitUsageInterface()
	 * @model required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	VInterface getUnitUsageInterface();

	/**
	 * Sets the value of the '{@link CVLMetamodelMaster.Main.ConfigurableUnitUsage#getUnitUsageInterface <em>Unit Usage Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Usage Interface</em>' reference.
	 * @see #getUnitUsageInterface()
	 * @generated
	 */
	void setUnitUsageInterface(VInterface value);

} // ConfigurableUnitUsage
