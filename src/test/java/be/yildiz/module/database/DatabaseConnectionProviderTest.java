package be.yildiz.module.database;//        This file is part of the Yildiz-Online project, licenced under the MIT License
//        (MIT)
//
//        Copyright (c) 2016 Grégory Van den Borre
//
//        More infos available: http://yildiz.bitbucket.org
//
//        Permission is hereby granted, free of charge, to any person obtaining a copy
//        of this software and associated documentation files (the "Software"), to deal
//        in the Software without restriction, including without limitation the rights
//        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//        copies of the Software, and to permit persons to whom the Software is
//        furnished to do so, subject to the following conditions:
//
//        The above copyright notice and this permission notice shall be included in all
//        copies or substantial portions of the Software.
//
//        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//        SOFTWARE.

import org.jooq.SQLDialect;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author Grégory Van den Borre
 */
public class DatabaseConnectionProviderTest {

    @Test
    public void testDatabaseConnectionProvider() throws SQLException {
        DbProperties properties = new DummyDatabaseConnectionProvider.DefaultProperties();
        DataBaseConnectionProvider dcp = new DummyDatabaseConnectionProvider(DataBaseConnectionProvider.DBSystem.MYSQL, properties, false);
        Assert.assertFalse(dcp.isDebug());
        Assert.assertEquals(properties.getDbUser(), dcp.getLogin());
        Assert.assertEquals(properties.getDbPassword(), dcp.getPassword());
    }

    @Test
    public void testDatabaseConnectionProviderMySql() throws SQLException {
        DbProperties properties = new DummyDatabaseConnectionProvider.DefaultProperties();
        DataBaseConnectionProvider dcp = new DummyDatabaseConnectionProvider(DataBaseConnectionProvider.DBSystem.MYSQL, properties, false);

        Assert.assertEquals(SQLDialect.MYSQL, dcp.getDialect());
        Assert.assertEquals(DataBaseConnectionProvider.DBSystem.MYSQL, dcp.getSystem());
        Assert.assertEquals("jdbc:mysql://" + properties.getDbHost() + ":" + properties.getDbPort() + "/" + properties.getDbName() + "?zeroDateTimeBehavior=convertToNull&useSSL=false", dcp.getUri());
    }

    @Test
    public void testDatabaseConnectionProviderDerby() throws SQLException {
        DbProperties properties = new DummyDatabaseConnectionProvider.DefaultProperties();
        DataBaseConnectionProvider dcp = new DummyDatabaseConnectionProvider(DataBaseConnectionProvider.DBSystem.DERBY, properties, false);

        Assert.assertEquals(SQLDialect.DERBY, dcp.getDialect());
        Assert.assertEquals(DataBaseConnectionProvider.DBSystem.DERBY, dcp.getSystem());
        Assert.assertEquals("jdbc:derby:target/database/" + properties.getDbName() + ";", dcp.getUri());
    }

    @Test(expected = NullPointerException.class)
    public void testDatabaseConnectionProviderNullSystem() throws SQLException {
        DbProperties properties = new DummyDatabaseConnectionProvider.DefaultProperties();
        new DummyDatabaseConnectionProvider(null, properties, false);
    }

    @Test(expected = NullPointerException.class)
    public void testDatabaseConnectionProviderNullProperties() throws SQLException {
        new DummyDatabaseConnectionProvider(DataBaseConnectionProvider.DBSystem.DERBY, null, false);
    }

}
